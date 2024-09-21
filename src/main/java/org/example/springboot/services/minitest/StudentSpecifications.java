package org.example.springboot.services.minitest;

import org.example.springboot.model.minitest.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecifications {
    public static Specification<Student> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("name"), name);
        };
    }

    public static Specification<Student> hasPhone(Long phone) {
        return (root, query, criteriaBuilder) -> {
            if (phone == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("phone"), phone);
        };
    }

    public static Specification<Student> hasGmail(String gmail) {
        return (root, query, criteriaBuilder) -> {
            if (gmail == null || gmail.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("gmail"), gmail);
        };
    }
}
