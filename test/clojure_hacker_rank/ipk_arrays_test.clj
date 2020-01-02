(ns clojure-hacker-rank.ipk-arrays-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-rank.rotate-left :refer [rotLeft]]
            [clojure-hacker-rank.hourglass :refer [hourglassSum]]))

(deftest rotate-left-test
  (testing "left rotating [1 2 3] once"
    (is (= (rotLeft [1 2 3] 1) [2 3 1])))
  (testing "left rotating [1 2 3] twice"
    (is (= (rotLeft [1 2 3] 2) [3 1 2]))))

(deftest hourglass-test
  (testing "all zeroes as input."
    (is (= (hourglassSum [[0 0 0] [0 0 0] [0 0 0]]) 0)))
  (testing "all ones as input."
    (is (= (hourglassSum [[1 1 1] [1 1 1] [1 1 1]]) 7))))