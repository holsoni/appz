package com.example.appza.service;

import com.example.appza.Stubs.BuildingStub;
import com.example.appza.Stubs.CoachStub;
import com.example.appza.Stubs.CompetitionStub;
import com.example.appza.model.Coach;
import com.example.appza.model.Competition;
import com.example.appza.repository.CoachRepository;
import com.example.appza.repository.CompetitionRepository;
import com.example.appza.service.Coach.CoachService;
import com.example.appza.service.Competition.CompetitionService;
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
class CompetitionServiceTest {

    private CompetitionService service;

    @Mock
    private CompetitionRepository repository;


    @BeforeEach
    void setup(){
        service = new CompetitionService(repository);
    }
    @Test
    void testSuccessfulGetById() {
        var role = CompetitionStub.getCompetition();
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(role));
        var result = service.getById(CompetitionStub.ID);
        System.out.println(result);
        assertAll(
                () -> assertEquals(result.get().getId(), role.getId()),
                () -> assertEquals(result.get().getName(), role.getName()),
                () -> assertEquals(result.get().getSport(), role.getSport()),
                () -> assertEquals(result.get().getCompetitionOrganizer(), role.getCompetitionOrganizer()),
                () -> assertEquals(result.get().getEvents(), role.getEvents()));
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
        var captor = ArgumentCaptor.forClass(Competition.class);
        var role = CompetitionStub.getCompetition();
        Mockito.when(repository.save(Mockito.any())).thenReturn(CompetitionStub.getCompetition());
        var result = service.create(CompetitionStub.getCompetition());
        Mockito.verify(repository, Mockito.atLeast(1)).save(captor.capture());
        assertAll(
                () -> assertEquals(result.getId(), role.getId()),
                () -> assertEquals(result.getName(), role.getName()),
                () -> assertEquals(result.getSport(), role.getSport()),
                () -> assertEquals(result.getCompetitionOrganizer(), role.getCompetitionOrganizer()),
                () -> assertEquals(result.getEvents(), role.getEvents()));

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
        var expect = CompetitionStub.getAll();

        Mockito.when(repository.findAll(PageRequest.of(CompetitionStub.page, CoachStub.size)))
                .thenReturn(new PageImpl<>(expect));

        var result = service.getAll(0, 2);

        assertAll(() -> {
            assertEquals(2L, result.getTotalElements());

            var res1 = result.getContent().get(0);
            var res2 = result.getContent().get(1);

            assertEquals(res1.getId(), expect.get(0).getId());
            assertEquals(res1.getName(), expect.get(0).getName());
            assertEquals(res1.getEvents(), expect.get(0).getEvents());
            assertEquals(res1.getCompetitionOrganizer(), expect.get(0).getCompetitionOrganizer());
            assertEquals(res1.getSport(), expect.get(0).getSport());


            assertEquals(res2.getId(), expect.get(1).getId());
            assertEquals(res2.getName(), expect.get(1).getName());
            assertEquals(res2.getEvents(), expect.get(1).getEvents());
            assertEquals(res2.getCompetitionOrganizer(), expect.get(1).getCompetitionOrganizer());
            assertEquals(res2.getSport(), expect.get(1).getSport());
        });
    }
}