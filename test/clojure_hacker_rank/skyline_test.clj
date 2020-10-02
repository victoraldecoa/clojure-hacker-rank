(ns clojure-hacker-rank.skyline-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-rank.skyline :refer :all]))

;; (deftest generate-skyline-test
  ;; (testing "short overlap"
    ;; (is (= (generate-skyline [[3 4 5] [1 7 1]]) [[1 1] [3 5] [4 5] [7 1]]))))

(deftest transform-to-events-test
  (testing "completely overlapped tall building"
    (is (= (transform-to-events [[3 4 5] [1 7 1]]) [[1 [1 7 1] up] [3 [3 4 5] up] [4 [3 4 5] down] [7 [1 7 1] down]]))))

(deftest up-test
  (testing "taller building on top of other"
    (is (= (up [1 2 3] [[nil nil 0]] []) [[[nil nil 0] [1 2 3]] [[1 3]]]))
  (testing "shorter building on top of other"
    (is (= (up [1.5 4 1] [[nil nil 0] [1 2 3]] [[1 3]]) [[[nil nil 0] [1.5 4 1] [1 2 3]] [[1 3]]])))))

(deftest down-test
  (testing "one building"
    (is (= (down [1 2 3] [[nil nil 0] [1 2 3]] [[1 3]]) [[[nil nil 0]] [[1 3] [2 0]]])))
  (testing "finishing shorter building"
    (is (= (down [1 2 3] [[nil nil 0] [1 2 3] [1 3 5]] [[1 5]]) [[[nil nil 0] [1 3 5]] [[1 5]]])))
  (testing "finishing taller building"
    (is (= (down [1 2 3] [[nil nil 0] [1 3 1] [1 2 3]] [[1 3]]) [[[nil nil 0] [1 3 1]] [[1 3] [2 1]]]))))
