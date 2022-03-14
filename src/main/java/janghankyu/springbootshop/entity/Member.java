package janghankyu.springbootshop.entity;

import janghankyu.springbootshop.constant.Role;
import janghankyu.springbootshop.dto.member.MemberFormDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String address;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Member(String name, String email, String address, String password, Role role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        return new Member(
                memberFormDto.getName(),
                memberFormDto.getEmail(),
                memberFormDto.getAddress(),
                passwordEncoder.encode(memberFormDto.getPassword()),
                Role.USER);
    }
}
