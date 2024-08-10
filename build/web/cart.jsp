<%@page import="dto.Mobile"%>
<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" type="text/css" href="Cart.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Hello user: <%= request.getSession().getAttribute("userId")%></h1>
        <p style="background-color:red;color:white;display:inline-block">${message}</p>
        <a href="MainController?action=Logout" class="btn btn-primary Logout">Logout</a>
        <form action="MainController">
            Min price: <input type="number" min="0" name="minPrice" />
            Max price: <input type="number" min="0" name="maxPrice" />
            <input type="submit" value="searchCart" name="action" /> 
        </form>
        <div class="container">
            <div class="row">
                <%
                    int count = 0;
                    List<Mobile> list = (List) request.getAttribute("mobiles");
                    if (list != null) {
                        for (Mobile mobile : list) {
                            if (count % 4 == 0 && count != 0) {
                %>
                                </div>
                                <div class="row">
                <%
                            }
                %>
                            <div class="col-md-3">
                                <div class="card">
                                    <img src="<%= mobile.getImage()%>" alt="Image" width="250" height="250">
                                    <div class="card-body">
                                        <h5 class="card-title"><%= mobile.getMobileName()%></h5>
                                        <p class="card-text"><%= mobile.getDescription()%></p>
                                        <p class="card-text">Price: <%= mobile.getPrice()%></p>
                                        <p class="card-text">Year: <%= mobile.getYearOfProduction()%></p>
                                        <p class="card-text">Quantity: <%= mobile.getQuantity()%></p>
                                        <p class="card-text status"><%= mobile.getNotSale() == 1 ? "Unavailable" : "Available" %></p>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="mobileId" value="<%= mobile.getMobileId()%>">
                                            <input type="submit" name="action" value="addToCart" class="btn btn-primary" <%= mobile.getNotSale() == 1 ? "disabled" : "" %>>
                                        </form>
                                    </div>
                                </div>
                            </div>
                <%
                            count++;
                        }
                    }
                %>
            </div>
        </div>

    <br>
    
    
    <h3>Cart</h3>
    <form action="MainController">
        <input type="submit" value="ViewCart" name="action" /> 
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Mobile ID</th> 
            </tr>
        </thead>
        <tbody>
            <%
                int cartCount = 0;
                List<Cart> carts = (List) request.getAttribute("carts");
                if (carts != null) {
                    for (Cart i : carts) {
                        cartCount++;
            %>
        <form action="MainController" method="POST">
            <tr>
                <td><%= cartCount%></td>
                <td><%= i.getMobileId()%></td>
                
                <td>
                    <a href="MainController?action=removeFromCart&cartId=<%= i.getCartId()%>">Delete</a>
                </td>
            </tr>
        </form>
        <%
                }
            }
        %>
        </tbody>
       <form action="invoice.jsp" method="get">
            <button type="submit" class="btn">Create Invoice</button>
        </form>
    </table>
</body>
</html>



