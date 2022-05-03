package wooteco.subway.dao;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import wooteco.subway.domain.Line;

public class LineDaoTest {

    private final LineDao lineDao = LineDao.getInstance();

    @Test
    @DisplayName("Line 을 저장한다.")
    void save() {
        //given
        Line line = new Line("가산디지털", "khaki");

        //when
        Line actual = lineDao.save(line);

        //then
        assertThat(equals(actual, line)).isTrue();
    }

    private boolean equals(Line lineA, Line lineB) {
        return lineA.getColor().equals(lineB.getColor()) && lineA.getName().equals(lineB.getName());
    }

    @Test
    @DisplayName("전체 Line 목록을 조회한다.")
    void findAll() {
        //given
        Line line1 = new Line("가산디지털", "blue");
        Line line2 = new Line("중곡", "khaki");
        lineDao.save(line1);
        lineDao.save(line2);

        //when
        List<Line> actual = lineDao.findAll();

        //then
        assertAll(
            () -> assertThat(equals(actual.get(0), line1)).isTrue(),
            () -> assertThat(equals(actual.get(1), line2)).isTrue()
        );
    }
}
