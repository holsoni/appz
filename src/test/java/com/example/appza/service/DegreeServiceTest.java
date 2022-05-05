package com.example.appza.service;

import com.example.appza.Stubs.CoachStub;
import com.example.appza.Stubs.CompetitionStub;
import com.example.appza.Stubs.DegreeStub;
import com.example.appza.model.Competition;
import com.example.appza.model.Degree;
import com.example.appza.repository.CompetitionRepository;
import com.example.appza.repository.DegreeRepository;
import com.example.appza.service.Competition.CompetitionService;
import com.example.appza.service.Degree.DegreeService;
import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DegreeServiceTest {
    private DegreeService service;

    @Mock
    private DegreeRepository repository;


    @BeforeEach
    void setup(){
        service = new DegreeService(repository);
    }
    @Test
    void testSuccessfulGetById() {
        var role = DegreeStub.getDegree();
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(role));
        var result = service.getById(DegreeStub.ID);
        System.out.println(result);
        assertAll(
                () -> assertEquals(result.get().getId(), role.getId()),
                () -> assertEquals(result.get().getDegree(), role.getDegree()),
                () -> assertEquals(result.get().getCreated_at(), role.getCreated_at()),
                () -> assertEquals(result.get().getDescription(), role.getDescription()),
                () -> assertEquals(result.get().getModified_at(), role.getModified_at()));
    }


    @Test
    void testNoSuccessfulGetById() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.empty());
//        var exception = assertThrows(NoSuchElementException.class, () -> service.getById(AccountRoleStub.ID));
//        assertEquals(exception.getMessage(), "No value present");
        var result = service.getById(CoachStub.ID);
        assertEquals(result, Optional.empty());

    }

    @Test
    void testSuccessfulSave() {
        var captor = ArgumentCaptor.forClass(Degree.class);
        var role = DegreeStub.getDegree();
        Mockito.when(repository.save(Mockito.any())).thenReturn(DegreeStub.getDegree());
        var result = service.create(DegreeStub.getDegree());
        Mockito.verify(repository, Mockito.atLeast(1)).save(captor.capture());
        assertAll(
                () -> assertEquals(result.getId(), role.getId()),
                () -> assertEquals(result.getDegree(), role.getDegree()),
                () -> assertEquals(result.getDescription(), role.getDescription()),
                () -> assertEquals(result.getModified_at(), role.getModified_at()),
                () -> assertEquals(result.getCreated_at(), role.getModified_at()));

    }

    @Test
    void testSuccessfulDelete() {
        service.delete(CompetitionStub.ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(repository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(CompetitionStub.ID, captor.getValue());
    }

    @Test
    void successfulGetAll() {
        var expect = DegreeStub.getAll();

        Mockito.when(repository.findAll(PageRequest.of(DegreeStub.page, DegreeStub.size)))
                .thenReturn(new PageImpl<>(expect));

        var result = service.getAll(0, 2);

        assertAll(() -> {
            assertEquals(2L, result.getTotalElements());

            var res1 = result.getContent().get(0);
            var res2 = result.getContent().get(1);

            assertEquals(res1.getId(), expect.get(0).getId());
            assertEquals(res1.getDegree(), expect.get(0).getDegree());
            assertEquals(res1.getCreated_at(), expect.get(0).getCreated_at());
            assertEquals(res1.getDescription(), expect.get(0).getDescription());
            assertEquals(res1.getModified_at(), expect.get(0).getModified_at());


            assertEquals(res2.getId(), expect.get(1).getId());
            assertEquals(res2.getDegree(), expect.get(1).getDegree());
            assertEquals(res2.getCreated_at(), expect.get(1).getCreated_at());
            assertEquals(res2.getDescription(), expect.get(1).getDescription());
            assertEquals(res2.getModified_at(), expect.get(1).getModified_at());
        });
    }

}