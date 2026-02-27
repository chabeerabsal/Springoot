//package Service;
//
//import org.ecommerce.dto.UserDto;
//import org.ecommerce.entity.User;
//
//import org.ecommerce.repository.UserRepository;
//import org.ecommerce.service.UserServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//    private UUID userId;
//    private User user;
//
//    @BeforeEach
//    void setUp() {
//        userId = UUID.randomUUID();
//
//        user = User.builder()
//                .id(userId)
//                .name("John")
//                .email("john@test.com")
//                .build();
//    }
//
//    @Test
//    void shouldReturnUserWhenUserExists() {
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//
//        UserDto result = userService.getUserById(userId);
//
//        assertNotNull(result);
//        assertEquals("John", result.getName());
//        assertEquals("john@test.com", result.getEmail());
//
//        verify(userRepository, times(1)).findById(userId);
//    }
//
//    @Test
//    void shouldThrowExceptionWhenUserNotFound() {
//        when(userRepository.findById(userId)).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class,
//                () -> userService.getUserById(userId));
//
//        verify(userRepository, times(1)).findById(userId);
//    }
//}