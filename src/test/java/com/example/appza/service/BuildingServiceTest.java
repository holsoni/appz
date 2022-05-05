package com.example.appza.service;

import com.example.appza.DTO.Building.BuildingResponse;
import com.example.appza.Stubs.BuildingStub;
import com.example.appza.model.Building;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.service.Building.BuildingService;
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

import java.sql.Date;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class BuildingServiceTest {

    private BuildingService service;

    @Mock
    private BuildingRepository repository;


    @BeforeEach
    void setup(){
        service = new BuildingService(repository);
    }
    @Test
    void testSuccessfulGetById() {
        var role = BuildingStub.getRandomBuilding();
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(role));
        var result = service.getById(BuildingStub.ID);
        System.out.println(result);
        assertAll(
                () -> assertEquals(result.get().getId(), role.getId()),
                () -> assertEquals(result.get().getName(), role.getName())
        );
    }


    @Test
    void testNoSuccessfulGetById() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.empty());
//        var exception = assertThrows(NoSuchElementException.class, () -> service.getById(AccountRoleStub.ID));
//        assertEquals(exception.getMessage(), "No value present");
        var result = service.getById(BuildingStub.ID);
        assertEquals(result, Optional.empty());

    }

    @Test
    void testSuccessfulSave() {
        var captor = ArgumentCaptor.forClass(Building.class);
        var role = BuildingStub.getRandomBuilding();
        Mockito.when(repository.save(Mockito.any())).thenReturn(BuildingStub.getRandomBuilding());
        var result = service.create(BuildingStub.getRandomBuilding());
        Mockito.verify(repository, Mockito.atLeast(1)).save(captor.capture());
        assertAll(
                () -> assertEquals(role, captor.getValue()),
                () -> assertEquals(role.getName(), result.getName())
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
        var expect = BuildingStub.getAll();

        Mockito.when(repository.findAll(PageRequest.of(BuildingStub.page, BuildingStub.size)))
                .thenReturn(new PageImpl<>(expect));

        var result = service.getAll(0, 2);

        assertAll(() -> {
            assertEquals(2L, result.getTotalElements());

            var res1 = result.getContent().get(0);
            var res2 = result.getContent().get(1);

            assertEquals(res1.getId(), expect.get(0).getId());
            assertEquals(res1.getName(), expect.get(0).getName());

            assertEquals(res2.getId(), expect.get(1).getId());
            assertEquals(res2.getName(), expect.get(1).getName());
        });
    }
}