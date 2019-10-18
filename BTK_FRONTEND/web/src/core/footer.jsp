<footer>
    <small> Copyright &copy;
        Luiz Sandoval, Matheus Fiaschi - 2019. Todos os direitos reservados.</small>

    <script src="../../assets/js/jquery-3.3.1.slim.min.js"></script>
    <script src="../../assets/js/popper.min.js"></script>
    <script src="../../assets/js/bootstrap.min.js"></script>
    <script src="../../assets/js/datatable/datatables.min.js"></script>

    <script>
        const overlay = document.getElementById('overlay');
        const menu = document.getElementById('menu');

        $(document).ready(() => initTables('genders', 'authors', 'books'));

        overlay.addEventListener('click', () => closeMenu());

        function openMenu() {
            menu.style.right = '0px';
            overlay.style.display = 'block';
        }

        function closeMenu() {
            menu.style.right = '-300px';
            overlay.style.display = 'none';
        }

        function logout() {
            window.location.href = "http://localhost:8080/BTK_FRONTEND/src/pages/login.jsp?action=logout";
        }

        function filterValues(tableName, e) {
            $(this.getTableName(tableName)).DataTable().search(e.target.value).draw();
        }

        function initTables(...tables) {
            tables.forEach(table => $(this.getTableName(table)).DataTable({"dom": 'lrtip' }));
        }

        getTableName = (tableName) => "#" + tableName + "Table";

        getLoans = type => window.location.href = "http://localhost:8080/BTK_FRONTEND/src/pages/main.jsp?TYPE=" + String(type);

    </script>
</footer>
