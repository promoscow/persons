package ru.xpendence.persons.util;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import ru.xpendence.persons.entity.Role;
import ru.xpendence.persons.entity.User;
import ru.xpendence.persons.repository.RoleRepository;
import ru.xpendence.persons.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 17:09
 * e-mail: v.chernyshov@pflb.ru
 */
@Component
@DependsOn({"roleRepository", "userRepository"})
public class InitUtil {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public InitUtil(RoleRepository roleRepository,
                    UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void init() {
        List<Role> roles = roleRepository.saveAll(createRoles());
        userRepository.saveAll(createUsers(roles));
    }

    private List<User> createUsers(List<Role> roles) {
        return Lists.newArrayList(
                new User("Остап", "Бендер", "Ибрагимович", "bender1929@mail.ru", "89001112233", Lists.newArrayList(roles.get(3))),
                new User("Киса", "Воробьянинов", "Викентьевич", "kisa-kisa@mail.ru", "89101298353", Lists.newArrayList(roles.get(2))),
                new User("Мадам", "Грицацуева", "Мадамовна", "madam-gric@ya.ru", "89157898764", Lists.newArrayList(roles.get(1  ))),
                new User("Отец", "Фёдор", "Петухов", "otec-batko@mail.ru", "89676560908", Lists.newArrayList(roles.get(0))),
                new User("Авессалом", "Изнурёнков", "Петрович", "poker@mail.ru", "89450908746", Lists.newArrayList(roles.get(3))),
                new User("Архивариус", "Коробейников", "Максимович", "archives@mail.ru", "89784545378", Lists.newArrayList(roles.get(2))),
                new User("Эллочка", "Людоедка", "Элитовна", "elite@mail.ru", "89569897653", Lists.newArrayList(roles.get(1))),
                new User("Осип", "Брезенчук", "Игнатьевич", "brezenchuk@mail.ru", "89089897657", Lists.newArrayList(roles.get(0))),
                new User("Илья", "Щукин", "Ильич", "engineer@mail.ru", "89896765653", Lists.newArrayList(roles.get(3))),
                new User("Глафира", "Петухова", "Аскольдовна", "12stulyev@mail.ru", "89787834323", Lists.newArrayList(roles.get(2)))
        );
    }

    private List<Role> createRoles() {
        return Lists.newArrayList(
                new Role("Зауральский Орк"),
                new Role("Йоркширский Хоббит"),
                new Role("Подмосковный гоблин"),
                new Role("Питерский эльф")
        );
    }
}
