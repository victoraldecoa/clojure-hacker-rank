; Interview Preparation Kit Dictionaries and Hashmaps tests
(ns clojure-hacker-rank.ipk-dictionaries-hashmaps-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-rank.longest-without-repeat :refer [longest]]))

(deftest longest-without-repeat-test
  (testing "empty string"
    (is (= (longest "") 0)))
  (testing "one character repeated"
    (is (= (longest "aaaaa") 1)))
  (testing "two different characters"
    (is (= (longest "ab") 2)))
  (testing "windowed case"
    (is (= (longest "abcdafg") 6)))
  (testing "two windows"
    (is (= (longest "aaaaabcdbcefgabbbb") 7))))