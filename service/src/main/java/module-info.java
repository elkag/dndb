module dndm.service {
    //requires org.slf4j;
    requires dndm.utilities;

    exports dndm.service.common;
    exports dndm.service.exposed.api;
    exports dndm.service.exposed.models;
    exports dndm.service.exposed.services;
}