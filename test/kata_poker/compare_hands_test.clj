(ns kata-poker.compare-hands-test
  (:require [clojure.test :refer :all]
            [kata-poker.hand-comparator :refer :all]))

(deftest test-compare-hands-by-high-card-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "4A" "8E" "9D" "AD")
          white '("3A" "4S" "9D" "TA" "KF")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-high-card-white-wins
  (testing "Comparing two single hands, first hand smaller"
    (let [black '("3S" "4A" "8E" "9D" "AD")
          white '("3A" "4S" "9D" "TA" "AF")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-pair-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "3A" "8E" "9D" "AD")
          white '("AA" "QS" "TD" "4A" "KF")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-pair-white-wins
  (testing "Comparing two single hands, first hand smaller"
    (let [black '("3S" "3A" "8E" "9D" "AD")
          white '("AA" "QS" "TD" "4A" "AF")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-two-pairs-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "3A" "8E" "2D" "2D")
          white '("AA" "QS" "TD" "4A" "AF")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-two-pairs-white-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "3A" "8E" "2D" "2D")
          white '("AA" "QS" "QD" "4A" "AF")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-triplet-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "4A" "2E" "2D" "2D")
          white '("AA" "QS" "TD" "4A" "AF")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-triplet-white-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "5A" "2E" "2D" "2D")
          white '("AA" "QS" "QD" "4A" "QF")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-straight-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "4A" "5E" "6D" "7D")
          white '("AA" "QS" "TD" "4A" "AF")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-straight-white-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "4A" "5E" "6D" "7D")
          white '("AA" "QS" "KD" "TA" "JF")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-flush-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "4S" "5S" "6S" "7S")
          white '("AA" "QS" "TD" "4A" "AF")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-flush-white-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "4A" "5E" "6D" "7D")
          white '("AD" "QD" "KD" "TD" "JD")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-full-house-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "3S" "5S" "5S" "5S")
          white '("AS" "QS" "TS" "4S" "AS")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-full-house-white-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "4A" "5E" "6D" "7D")
          white '("AD" "AD" "AD" "TD" "TD")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-quadruple-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("3S" "2S" "2S" "2S" "2S")
          white '("AS" "AS" "AS" "QS" "QS")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-quadruple-white-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("2S" "2A" "2E" "2D" "7D")
          white '("AD" "AD" "AD" "AD" "TD")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-by-straight-flush-black-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("2S" "3S" "4S" "5S" "6S")
          white '("AS" "AS" "AS" "QS" "QS")
          result (compare-hands black white)]
    (is (pos? result)))))

(deftest test-compare-hands-by-straight-flush-white-wins
  (testing "Comparing two single hands, first hand higher"
    (let [black '("2S" "2A" "2E" "2D" "7D")
          white '("5D" "6D" "7D" "8D" "9D")
          result (compare-hands black white)]
    (is (neg? result)))))

(deftest test-compare-hands-tie
  (testing "Comparing two single hands, hands tie"
    (let [black '("3S" "4A" "8E" "9D" "AD")
          white '("3A" "4S" "8D" "9A" "AF")
          result (compare-hands black white)]
    (is (zero? result)))))

