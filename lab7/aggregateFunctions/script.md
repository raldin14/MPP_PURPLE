## 6.12 How many hotels are there?
SELECT COUNT(*) as hotel_count from Hotel;


## 6.13 What is the average price of a room
SELECT AVG(price) as average_price from Room;


## 6.14 What is the total revenue per night from all double rooms?
SELECT SUM(price) as total_double_room_revenue from Room where type='double';
### using joins  to calculate the total revenue 
    SELECT 
    SUM(DATEDIFF(dateTo, dateFrom) * r.price) AS total_double_room_revenue
    FROM Booking b
    JOIN Room r ON b.hotelNo = r.hotelNo AND b.roomNo = r.roomNo
    WHERE r.type = 'Double';


## How many different guests have made bookings from August?
SELECT COUNT(DISTINCT guestNo) as august_guest_count from Booking where MONTH(dateFrom) = 8;



