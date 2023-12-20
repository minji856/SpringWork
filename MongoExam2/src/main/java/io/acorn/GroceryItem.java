package io.acorn;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // 인자있는 생성자
public class GroceryItem {
    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;
}
