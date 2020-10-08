(ns clojure-hacker-rank.skyline-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-rank.skyline :refer :all]))

(deftest generate-skyline-test
  (testing "short overlap"
    (is (= (generate-skyline [[3 4 5] [1 7 1]]) [[1 1] [3 5] [4 1] [7 0]])))
  (testing "same height buildings"
    (is (= (generate-skyline [[1 3 5] [2 4 5]]) [[1 5] [4 0]]))))

(deftest transform-to-events-test
  (testing "completely overlapped tall building"
    (is (= (transform-to-events [[3 4 5] [1 7 1]]) [(->Event 1 (->Building 1 7 1) up) (->Event 3 (->Building 3 4 5) up) (->Event 4 (->Building 3 4 5) down) (->Event 7 (->Building 1 7 1) down)]))))

(deftest up-test
  (testing "taller building on top of other"
    (is (= (up (->Building 1 2 3) (create-set) []) [(create-set (->Building 1 2 3)) [[1 3]]])))
  (testing "shorter building on top of other"
    (is (= (up (->Building 1.5 4 1) (create-set (->Building 1 2 3)) [[1 3]]) [(create-set (->Building 1.5 4 1) (->Building 1 2 3)) [[1 3]]]))))

(deftest down-test
  (testing "one building"
    (is (= (down (->Building 1 2 3) (create-set (->Building 1 2 3)) [[1 3]]) [(create-set) [[1 3] [2 0]]])))
  (testing "finishing shorter building"
    (is (= (down (->Building 1 2 3) (create-set (->Building 1 2 3) (->Building 1 3 5)) [[1 5]]) [(create-set (->Building 1 3 5)) [[1 5]]])))
  (testing "finishing taller building"
    (is (= (down (->Building 1 2 3) (create-set (->Building 1 3 1) (->Building 1 2 3)) [[1 3]]) [(create-set (->Building 1 3 1)) [[1 3] [2 1]]])))
  (testing "finishing same height building"
    (is (= (down (->Building 2 4 5) (create-set (->Building 1 3 5) (->Building 2 4 5)) [[1 5]]) [(create-set (->Building 1 3 5)) [[1 5]]]))))
