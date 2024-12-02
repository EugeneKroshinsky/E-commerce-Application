<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/order" method="post">
    <label for="firstName">First Name</label>
    <input type="text" id="firstName" name="firstName" required>

    <label for="lastName">Last Name</label>
    <input type="text" id="lastName" name="lastName" required>

    <label for="email">Email</label>
    <input type="email" id="email" name="email" required>

    <label for="phone">Phone Number</label>
    <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" placeholder="1234567890" required>

    <label for="address">Delivery Address</label>
    <input type="text" id="address" name="address" required>

    <label for="comment">Comment</label>
    <textarea id="comment" name="comment" rows="4" placeholder="Optional"></textarea>

    <button type="submit">Place Order</button>
</form>
</body>
</html>
