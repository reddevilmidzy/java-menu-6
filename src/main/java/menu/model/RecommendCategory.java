package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecommendCategory implements Iterator<Category> {

    private List<Category> categories;
    private Iterator<Category> iterator;

    public RecommendCategory() {
        this.categories = new ArrayList<>();
    }

    public boolean canRecommend(Category target) {
        return Collections.frequency(categories, target) < 2;
    }

    public void add(Category category) {
        categories.add(category);
    }

    public boolean isDone() {
        return categories.size() == 5;
    }

    public void initIterator() {
        iterator = categories.iterator();
    }

    public String join(String value) {
        StringBuilder builder = new StringBuilder();
        initIterator();
        Category category = iterator.next();
        builder.append(category.getName());
        while (iterator.hasNext()) {
            builder.append(value);
            category = iterator.next();
            builder.append(category.getName());
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return categories.toString();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Category next() {
        return iterator.next();
    }
}
