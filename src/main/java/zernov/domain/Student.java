package zernov.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Student {
    private final long id;
    private final String surname;
    private final String name;
    private final String middleName;
}
