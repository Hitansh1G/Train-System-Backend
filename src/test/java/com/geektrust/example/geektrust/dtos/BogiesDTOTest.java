//package com.geektrust.example.geektrust.dtos;
//
////package com.geektrust.example.geektrust.dtos;
//
//import com.geektrust.example.geektrust.entities.Bogie;
//import com.geektrust.example.geektrust.entities.Station;
//import com.geektrust.example.geektrust.repositories.IBogieRepository;
//import com.geektrust.example.geektrust.repositories.IStationRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class BogiesDTOTest {
//
//    private BogiesDTO bogiesDTO;
//
//    @Mock
//    private IBogieRepository bogieRepositoryMock;
//
//    @Mock
//    private IStationRepository stationRepositoryMock;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        bogiesDTO = new BogiesDTO();
//    }
//
//    @Test
//    public void testCreateListOfBogies() {
//        String stationCode1 = "STN1";
//        String stationCode2 = "STN2";
//        Station station1 = new Station("Station1", stationCode1, 100);
//        Station station2 = new Station("Station2", stationCode2, 150);
//
//        List<String> bogieNames = Arrays.asList(stationCode1, stationCode2);
//
//        when(stationRepositoryMock.findStationByCode(stationCode1)).thenReturn(station1);
//        when(stationRepositoryMock.findStationByCode(stationCode2)).thenReturn(station2);
//
//        LinkedList<Bogie> bogies = BogiesDTO.createListOfBogies(bogieRepositoryMock, stationRepositoryMock, bogieNames);
//
//        assertNotNull(bogies);
//        assertEquals(2, bogies.size());
//        assertEquals(station1, bogies.get(0).getdestinationStation());
//        assertEquals(station2, bogies.get(1).getdestinationStation());
//
//        verify(bogieRepositoryMock, times(2)).save(any(Bogie.class));
//    }
//}
