package com.jhao.playdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PersonLocal<T> {
    private static final Map<PersonLocalKey, Object> sValues = new HashMap<>();

    public void set(@NonNull Person person, @NonNull T attribute) {
        sValues.put(new PersonLocalKey(person, attribute.getClass()), attribute);
    }

    public T get(@NonNull Person person, @NonNull Class<T> attributeType) {
        Object object = sValues.get(new PersonLocalKey(person, attributeType));
        if (object != null) {
            @SuppressWarnings("unchecked")
            T ret = ((T) object);
            return ret;
        }
        return null;
    }

    public void remove(@NonNull Person person, @NonNull Class<T> attributeType) {
        sValues.remove(new PersonLocalKey(person, attributeType));
    }

    public int size() {
        return sValues.size();
    }

    public static void testPersonLocal() {
        PersonLocal<Gender> genderPersonLocal = new PersonLocal<>();

        Person bob = new Person("bob");
        genderPersonLocal.set(bob, Gender.MALE);//逻辑上 相当于bob.setGender(Gender.MALE)。
        Gender bobGender = genderPersonLocal.get(bob, Gender.class);//逻辑上 相当于Gender bobGender=bob.getGender()。
        System.out.println("bob is " + bobGender);

        Person mei = new Person("mei");
        genderPersonLocal.set(mei, Gender.FEMALE);
        System.out.println("mei is " + genderPersonLocal.get(mei, Gender.class));

        genderPersonLocal.remove(bob, Gender.class);
        genderPersonLocal.remove(mei, Gender.class);

        assert genderPersonLocal.size() == 0;

    }

}

enum Gender {
    MALE,
    FEMALE,
}

class PersonLocalKey {
    @NonNull
    private final Person person;
    @NonNull
    private final Class<?> attribute;

    PersonLocalKey(@NonNull Person person,
                   @NonNull Class<?> attribute) {
        this.person = person;
        this.attribute = attribute;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + System.identityHashCode(person);
        result = result * 31 + System.identityHashCode(attribute);
        return result;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PersonLocalKey) {
            PersonLocalKey other = ((PersonLocalKey) obj);
            return other.person == this.person && other.attribute == this.attribute;
        }
        return super.equals(obj);
    }
}