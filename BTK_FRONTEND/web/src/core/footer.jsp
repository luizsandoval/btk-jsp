<footer>
    <small> Copyright &copy;
        Luiz Sandoval, Matheus Fiaschi - 2019. Todos os direitos reservados.</small>

    <script src="../../assets/js/jquery-3.3.1.slim.min.js"></script>
    <script src="../../assets/js/popper.min.js"></script>
    <script src="../../assets/js/bootstrap.min.js"></script>
    <script>
        let overlay = document.getElementById('overlay');
        let menu = document.getElementById('menu');

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

    </script>
</footer>
