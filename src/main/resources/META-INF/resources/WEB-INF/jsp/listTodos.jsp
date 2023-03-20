<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
  <div class="container">
<H1>Your Todos are: </H1>
<table class="table">
      <thead>
         <tr>

             <th>description</th>
             <th>targetDate</th>
             <th>isDone</th>
         </tr>
      </thead>
      <tbody>
           <c:forEach items="${todos}" var="todo">
           <tr>

              <td>${todo.description}</td>
              <td>${todo.targetDate}</td>
              <td>${todo.done}</td>
              <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
              <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
           </tr>
           </c:forEach>
      </tbody>

</table>
<a href="add-todo" class="btn btn-success">Add Todos</a>
</div>
<%@ include file="common/footer.jspf" %>
