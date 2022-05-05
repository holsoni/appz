package com.example.appza.service;

import com.example.appza.Stubs.BuildingStub;
import com.example.appza.Stubs.CoachStub;
import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.repository.CoachRepository;
import com.example.appza.service.Building.BuildingService;
import com.example.appza.service.Coach.CoachService;
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
class CoachServiceTest {

    private CoachService service;

    @Mock
    private CoachRepository repository;


    @BeforeEach
    void setup(){
        service = new CoachService(repository);
    }
    @Test
    void testSuccessfulGetById() {
        var role = CoachStub.getCoach();
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(role));
        var result = service.getById(CoachStub.ID);
        System.out.println(result);
        assertAll(
                () -> assertEquals(result.get().getId(), role.getId()),
                () -> assertEquals(result.get().getName(), role.getName()),
                () -> assertEquals(result.get().getSport(), role.getSport()),
                () -> assertEquals(result.get().getYear(), role.getYear()),
                () -> assertEquals(result.get().getSportClub(), role.getSportClub()),
                () -> assertEquals(result.get().getCreated_at(), role.getCreated_at()),
                () -> assertEquals(result.get().getModified_at(), role.getModified_at()),
                () -> assertEquals(result.get().getDescription(), role.getDescription()));
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
        var captor = ArgumentCaptor.forClass(Coach.class);
        var role = CoachStub.getCoach();
        Mockito.when(repository.save(Mockito.any())).thenReturn(CoachStub.getCoach());
        var result = service.create(CoachStub.getCoach());
        Mockito.verify(repository, Mockito.atLeast(1)).save(captor.capture());
        assertAll(
                () -> assertEquals(role, captor.getValue()),
                () -> assertEquals(role.getName(), result.getName()),
                () -> assertEquals(role.getYear(), result.getYear()),
                () -> assertEquals(role.getSport(), result.getSport()),
                () -> assertEquals(role.getSportClub(), result.getSportClub()),
                () -> assertEquals(role.getCreated_at(), result.getCreated_at()),
                () -> assertEquals(role.getModified_at(), result.getModified_at()),
                () -> assertEquals(role.getDescription(), result.getDescription())
        );
    }

    @Test
    void testSuccessfulDelete() {
        service.delete(BuildingStub.ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(repository, Mockito.atLeast(1)).deleteById(captor.capture());
        assertEquals(BuildingStub.ID, captor.getValue());
    }

    @Test
    void successfulGetAll() {
        var expect = CoachStub.getAll();

        Mockito.when(repository.findAll(PageRequest.of(CoachStub.page, CoachStub.size)))
                .thenReturn(new PageImpl<>(expect));

        var result = service.getAll(0, 2);

        assertAll(() -> {
            assertEquals(2L, result.getTotalElements());

            var res1 = result.getContent().get(0);
            var res2 = result.getContent().get(1);

            assertEquals(res1.getId(), expect.get(0).getId());
            assertEquals(res1.getName(), expect.get(0).getName());
            assertEquals(res1.getYear(), expect.get(0).getYear());
            assertEquals(res1.getSportClub(), expect.get(0).getSportClub());
            assertEquals(res1.getSport(), expect.get(0).getSport());


            assertEquals(res2.getId(), expect.get(1).getId());
            assertEquals(res2.getName(), expect.get(1).getName());
            assertEquals(res2.getYear(), expect.get(1).getYear());
            assertEquals(res2.getSportClub(), expect.get(1).getSportClub());
            assertEquals(res2.getSport(), expect.get(1).getSport());
        });
    }
}