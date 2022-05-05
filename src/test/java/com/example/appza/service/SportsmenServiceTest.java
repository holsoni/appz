package com.example.appza.service;

import com.example.appza.DTO.Mapper;
import com.example.appza.Stubs.CoachStub;
import com.example.appza.Stubs.CompetitionStub;
import com.example.appza.Stubs.SportStub;
import com.example.appza.Stubs.SportsmenStub;
import com.example.appza.repository.SportRepository;
import com.example.appza.repository.SportsmenRepository;
import com.example.appza.service.Sport.SportService;
import com.example.appza.service.Sportsmen.SportsmenService;
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
class SportsmenServiceTest {
    private SportsmenService service;
    private Mapper mapper;

    @Mock
    private SportsmenRepository repository;


    @BeforeEach
    void setup(){
        service = new SportsmenService(repository, mapper);
    }
    @Test
    void testSuccessfulGetById() {
        var role = SportsmenStub.getSportsmen();
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(role));
        var result = service.getById(SportStub.ID);
        System.out.println(result);
        assertAll(
                () -> assertEquals(result.get().getId(), role.getId()),
                () -> assertEquals(result.get().getSport(), role.getSport()),
                () -> assertEquals(result.get().getDegree(), role.getDegree()),
                () -> assertEquals(result.get().getName(), role.getName()));

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
        var captor = ArgumentCaptor.forClass(SportsmenStub.class);
        var role = SportStub.getSport();
        Mockito.when(repository.save(Mockito.any())).thenReturn(SportsmenStub.getSportsmen());
        var result = service.create(SportsmenStub.getSportsmen());
        //Mockito.verify(repository, Mockito.atLeast(1)).save(captor.capture());
        assertAll(
                () -> assertEquals(result.getId(), role.getId()),
                () -> assertEquals(result.getSport(), role.getSport()),
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
        var expect = SportsmenStub.getAll();

        Mockito.when(repository.findAll(PageRequest.of(SportsmenStub.page, SportsmenStub.size)))
                .thenReturn(new PageImpl<>(expect));

        var result = service.getAll(0, 2);

        assertAll(() -> {
            assertEquals(2L, result.getTotalElements());

            var res1 = result.getContent().get(0);
            var res2 = result.getContent().get(1);

            assertEquals(res1.getId(), expect.get(0).getId());
            assertEquals(res1.getSport(), expect.get(0).getSport());
            assertEquals(res1.getCreated_at(), expect.get(0).getCreated_at());
            assertEquals(res1.getDescription(), expect.get(0).getDescription());
            assertEquals(res1.getModified_at(), expect.get(0).getModified_at());


            assertEquals(res2.getId(), expect.get(1).getId());
            assertEquals(res2.getSport(), expect.get(1).getSport());
            assertEquals(res2.getCreated_at(), expect.get(1).getCreated_at());
            assertEquals(res2.getDescription(), expect.get(1).getDescription());
            assertEquals(res2.getModified_at(), expect.get(1).getModified_at());
        });
    }
}