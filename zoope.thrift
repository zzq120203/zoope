namespace java cn.ac.iie.zoope.server
namespace go cn.ac.iie.zoope.server
namespace py cn.ac.iie.zoope.server

struct ZoopeAck {
    1:string status,
    2:string message
}

enum ActionType {

    INSERT,
    SEARCH,
    DELETE,
    UPDATE,
}

struct ZoopeAction {
    1:ActionType type,
    2:string db,
    3:string table,
    4:string message
}

service Zoope {

    ZoopeAck doInsert(1:ZoopeAction action)

    ZoopeAck doSearch(1:ZoopeAction action)

    ZoopeAck doDelete(1:ZoopeAction action)

    ZoopeAck doUpdate(1:ZoopeAction action)

}