package tn.esprit.devops_project.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ActivitySectorImplTest {

    @InjectMocks
    private ActivitySectorImpl activitySectorService;

    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllActivitySectors() {
        List<ActivitySector> activitySectors = new ArrayList<>();
        // Ajoutez des éléments à la liste activitySectors ici

        when(activitySectorRepository.findAll()).thenReturn(activitySectors);

        List<ActivitySector> result = activitySectorService.retrieveAllActivitySectors();
        assertEquals(activitySectors, result);
    }

    @Test
    public void testAddActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        // Initialisez activitySector avec les données appropriées

        when(activitySectorRepository.save(activitySector)).thenReturn(activitySector);

        ActivitySector result = activitySectorService.addActivitySector(activitySector);
        assertEquals(activitySector, result);
    }

    @Test
    public void testDeleteActivitySector() {
        Long id = 1L; // ID à supprimer

        doNothing().when(activitySectorRepository).deleteById(id);

        activitySectorService.deleteActivitySector(id);
        verify(activitySectorRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateActivitySector() {
        ActivitySector activitySector = new ActivitySector();
        // Initialisez activitySector avec les données appropriées

        when(activitySectorRepository.save(activitySector)).thenReturn(activitySector);

        ActivitySector result = activitySectorService.updateActivitySector(activitySector);
        assertEquals(activitySector, result);
    }

    @Test
    public void testRetrieveActivitySector() {
        Long id = 1L; // ID à rechercher
        ActivitySector activitySector = new ActivitySector();
        // Initialisez activitySector avec les données appropriées

        when(activitySectorRepository.findById(id)).thenReturn(Optional.of(activitySector));

        ActivitySector result = activitySectorService.retrieveActivitySector(id);
        assertEquals(activitySector, result);
    }
}
