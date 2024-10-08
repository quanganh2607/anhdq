package Model;

public class Room {
    private int roomId;
    private int motelId;
    private int typeId;
    private String roomTypeName;
    private String motelName;

    // Constructors, getters, and setters
    public Room(int roomId, int motelId, int typeId, String roomTypeName, String motelName) {
        this.roomId = roomId;
        this.motelId = motelId;
        this.typeId = typeId;
        this.roomTypeName = roomTypeName;
        this.motelName = motelName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getMotelId() {
        return motelId;
    }

    public void setMotelId(int motelId) {
        this.motelId = motelId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getMotelName() {
        return motelName;
    }

    public void setMotelName(String motelName) {
        this.motelName = motelName;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", motelId=" + motelId + ", typeId=" + typeId + ", roomTypeName=" + roomTypeName + ", motelName=" + motelName + '}';
    }
    
}
