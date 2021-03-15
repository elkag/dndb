module dndm.utilities {

    requires java.sql;
    //requires org.slf4j;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires java.persistence;
    requires java.xml.bind;
    requires com.fasterxml.classmate;
    requires java.naming;
    requires net.bytebuddy;

    opens dndm.utilities.data.api.entities to org.hibernate.orm.core;

    exports dndm.utilities.data.api;
    exports dndm.utilities.data.api.entities;
    exports dndm.utilities.data.api.repositories;
}