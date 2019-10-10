package t1708e.spring.assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import t1708e.spring.assignment.entity.Student;
import t1708e.spring.assignment.repository.StudentRepository;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(username).orElse(null);
        if (student == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        //System.out.println(account.getRoles().stream().map(x -> x.getName()).toArray());
        UserDetails user =
                User.builder()
                        .username(student.getEmail())
                        .password(student.getPassword())
                        .roles("USER")
                        .build();
        return user;
    }
}
