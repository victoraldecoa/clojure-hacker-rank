(ns clojure-hacker-rank.ipk-arrays-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-rank.rotate-left :refer [rotLeft]]))

(deftest rotate-left-test
  (testing "left rotating [1 2 3] once"
    (is (= (rotLeft [1 2 3] 1) [2 3 1])))
  (testing "left rotating [1 2 3] twice"
    (is (= (rotLeft [1 2 3] 2) [3 1 2]))))