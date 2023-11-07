
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OperatorServiceImplTest {
    ///
    @InjectMocks
    OperatorServiceImpl operatorService;

    @Mock
    OperatorRepository operatorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRetrieveAllOperators() {
        // Créer une liste factice d'opérateurs pour simuler la base de données
        List<Operator> operatorList = new ArrayList<>();
        operatorList.add(new Operator(1L, "John", "Doe", "password", null));
        operatorList.add(new Operator(2L, "Jane", "Smith", "password", null));

        when(operatorRepository.findAll()).thenReturn(operatorList);

        List<Operator> result = operatorService.retrieveAllOperators();

        // Vérifier que la méthode du service a renvoyé la liste simulée
        assertEquals(operatorList, result);
    }

    @Test
    void testAddOperator() {
        Operator operatorToAdd = new Operator(1L, "John", "Doe", "password", null);

        when(operatorRepository.save(operatorToAdd)).thenReturn(operatorToAdd);

        Operator result = operatorService.addOperator(operatorToAdd);

        // Vérifier que la méthode du service a renvoyé l'opérateur ajouté
        assertEquals(operatorToAdd, result);
    }

    @Test
    void testDeleteOperator() {
        Long operatorId = 1L;

        // Aucun besoin de simuler la réponse de la méthode delete, car elle ne renvoie rien

        operatorService.deleteOperator(operatorId);

        // Vérifier que la méthode delete du repository a été appelée avec l'ID correct
        verify(operatorRepository, times(1)).deleteById(operatorId);
    }

    @Test
    void testUpdateOperator() {
        Operator operatorToUpdate = new Operator(1L, "John", "Doe", "password", null);

        when(operatorRepository.save(operatorToUpdate)).thenReturn(operatorToUpdate);

        Operator result = operatorService.updateOperator(operatorToUpdate);

        // Vérifier que la méthode du service a renvoyé l'opérateur mis à jour
        assertEquals(operatorToUpdate, result);
    }

    @Test
    void testRetrieveOperator() {
        Long operatorId = 1L;
        Operator operator = new Operator(operatorId, "John", "Doe", "password", null);

        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));

        Operator result = operatorService.retrieveOperator(operatorId);

        // Vérifier que la méthode du service a renvoyé l'opérateur simulé
        assertEquals(operator, result);
    }
}
