package com.elif.ecommercebackend.config;

import com.elif.ecommercebackend.entity.Category;
import com.elif.ecommercebackend.entity.Role;
import com.elif.ecommercebackend.repository.CategoryRepository;
import com.elif.ecommercebackend.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(RoleRepository roleRepository, CategoryRepository categoryRepository) {
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Rollerin eklenmesi
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(null, "Admin", "admin"));
            roleRepository.save(new Role(null, "Store", "store"));
            roleRepository.save(new Role(null, "Customer", "customer"));
            System.out.println("Default roles created successfully.");
        }

        // Örnek kategorilerin eklenmesi
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category(null, "Kadın T-Shirt", "https://picsum.photos/200", 4.5, "kadin"));
            categoryRepository.save(new Category(null, "Erkek Ceket", "https://picsum.photos/200", 4.8, "erkek"));
            categoryRepository.save(new Category(null, "Ayakkabı", "https://picsum.photos/200", 4.2, "unisex"));
            System.out.println("Default categories created successfully.");
        }
    }
}