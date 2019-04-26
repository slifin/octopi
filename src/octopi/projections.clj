(ns octopi.projections
  "Functions to deal with schedule projection queries"
  (:require
    [honeysql.core :as sql]))

;; Columns

(defn ids
  "This will change"
  []
  [:nid :vid])

;; Tables

(defn table []
  [:appointment_appointments])

;; Conditions

(defn started? [date]
  [:>= :start_date date])

(defn not-ended? [date]
  [:or
    [:<= :end_date date]
    [:= :end_date 0]])

(defn not-deleted? []
  [:!= :deleted 1])

(defn on-day? [day]
  [:= (keyword day) 1])

(comment
  (sql/format
    {:select (ids)
     :from (table)
     :where [:and
               (started? 1234)
               (not-ended? 123)
               (not-deleted?)
               (on-day? "mon")]}))

