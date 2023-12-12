package menu.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements Generator<Integer> {


    // TODO: 하드코딩 제거
    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
