package edu.platform.application.validators;

import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.*;

public class Validator<T> {
    private T value;

    private Validator(T value) {
        this.value = value;
    }

    public static <T> Validator<T> of(T value) {
        return new Validator<>(value);
    }

    public Validator<T> requireNonNull(Supplier<? extends RuntimeException> exception) {
        if (Objects.isNull(value)) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonBlank(Function<T, String> apply, Supplier<? extends RuntimeException> exception) {
        if (ObjectUtils.isEmpty(apply.apply(value))) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultInteger(Function<T, Integer> apply, Supplier<? extends RuntimeException> exception) {
        Integer number = apply.apply(value);
        if (number == null || number == 0) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultInt(ToIntFunction<T> apply, Supplier<? extends RuntimeException> exception) {
        if (apply.applyAsInt(value) == 0) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultLong(Function<T, Long> apply, Supplier<? extends RuntimeException> exception) {
        Long number = apply.apply(value);
        if (number == null || number == 0) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultLong(ToLongFunction<T> apply, Supplier<? extends RuntimeException> exception) {
        if (apply.applyAsLong(value) == 0) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultDouble(Function<T, Double> apply, Supplier<? extends RuntimeException> exception) {
        Double number = apply.apply(value);
        if (number == null || number == 0) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultDouble(ToDoubleFunction<T> apply, Supplier<? extends RuntimeException> exception) {
        if (apply.applyAsDouble(value) == 0) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultFloat(Function<T, Float> apply, Supplier<? extends RuntimeException> exception) {
        Float number = apply.apply(value);
        if (number == null || number == 0) {
            throw exception.get();
        }

        return this;
    }

    public Validator<T> requireNonDefaultDate(Function<T, Timestamp> apply, Supplier<? extends RuntimeException> exception) {
        Timestamp date = apply.apply(value);
        if (date == null) {
            throw exception.get();
        }

        return this;
    }

    public <P> Validator<T> validate(Function<T, P> apply, Predicate<P> condition, Supplier<? extends RuntimeException> exception) {
        if (condition.test(apply.apply(value))) {
            throw exception.get();
        }

        return this;
    }

    public T get() {
        return value;
    }


}
