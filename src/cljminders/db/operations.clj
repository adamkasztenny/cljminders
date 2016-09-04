(ns cljminders.db.operations
  (:require [cljminders.db.connection :as db])
)

(use 'korma.db)
(use 'korma.core)

(defn createReminder [reminderValues] (insert db/reminders (values reminderValues)))

(defn selectReminders [] (select db/reminders))

(defn updateReminder [reminderValues id] (update db/reminders (set-fields reminderValues) (where (= :id id))))

(defn deleteReminder [id] (delete db/reminders (where (= :id id))))

(defn printReminder [reminder] 
	(def id (get reminder :id))
	(def description (get reminder :description))
	(def time (get reminder :time))
	(println id "  |" time "-" description)
)
