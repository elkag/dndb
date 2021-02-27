module dndm.service {
    requires org.slf4j;
    requires dndm.utilities;

    opens dndm.service.settlement.entities to dndm.utilities;
    opens dndm.service.merchant.entities to dndm.utilities;
    opens dndm.service.item.entities to dndm.utilities;

    exports dndm.service.common;
    exports dndm.service.exposed.api;
    exports dndm.service.exposed.models;
}