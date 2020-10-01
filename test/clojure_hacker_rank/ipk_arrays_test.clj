; Interview Preparation Kit Arrays tests
(ns clojure-hacker-rank.ipk-arrays-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-rank.rotate-left :refer [rotate-left]]
            [clojure-hacker-rank.hourglass :refer [hourglass-sum]]))

(deftest rotate-left-test
  (testing "left rotating [1 2 3] once"
    (is (= (rotate-left [1 2 3] 1) [2 3 1])))
  (testing "left rotating [1 2 3] twice"
    (is (= (rotate-left [1 2 3] 2) [3 1 2]))))

(deftest hourglass-test
  (testing "all zeroes as input."
    (is (= (hourglass-sum [[0 0 0] [0 0 0] [0 0 0]]) 0)))
  (testing "all ones as input."
    (is (= (hourglass-sum [[1 1 1] [1 1 1] [1 1 1]]) 7)))
  (testing "1s at the top left."
    (is (= (hourglass-sum [[1 1 1 -10] [1 1 1 -10] [1 1 1 -10] [-10 -10 -10 -10]]) 7))))
