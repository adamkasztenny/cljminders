; Thanks to https://github.com/korma/Korma
(ns cljminders.db.dbConnection)
(use 'korma.db)
(use 'korma.core)

(def db (h2 {:db "reminders.db"}))

(defentity reminders
    (pk :id) 
    (table :reminders)
    (database reminders)
    (entity-fields :description :time :date)
)
