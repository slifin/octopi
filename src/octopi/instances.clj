(ns octopi.instances
  "Functions to define instance queries"
  (:require
      [honeysql.core :as sql]))

;; Columns
(defn ids[]
  [:nid :vid])

;; Tables
(defn table []
  [:appointment_instances])

;; Conditions
(defn started? [start-date]
  [:>= :instance_date start-date])

(defn ended? [end-date]
  [:<= :instance_date end-date])

(defn client? [uid]
  [:= :uid uid])

(comment
  (sql/format {:select (ids)
               :from (table)
               :where [:and
                        (started? 1556313105)
                        (ended? 1556319600)
                        (client? 23)]}))

