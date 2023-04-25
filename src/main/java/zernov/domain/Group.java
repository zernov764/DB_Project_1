package zernov.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Group {
    private final long id;
    private final String number;
    private final String entrance;
}