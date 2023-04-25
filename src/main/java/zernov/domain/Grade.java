package zernov.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Grade {
    private final long id;
    private final String grade;

}
