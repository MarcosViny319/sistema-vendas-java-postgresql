public void cadastrar(Cliente cliente) {

    String sql = """
        INSERT INTO clientes (nome, cidade, estado)
        VALUES (?, ?, ?)
        """;

    try (Connection con = Conexao.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCidade());
        stmt.setString(3, cliente.getEstado());

        stmt.executeUpdate();

        System.out.println("Cliente cadastrado!");

    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }
}

public void listar() {

    String sql = "SELECT * FROM clientes";

    try (Connection con = Conexao.conectar();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            System.out.println(
                rs.getInt("id_cliente") + " - " +
                rs.getString("nome") + " - " +
                rs.getString("cidade") + " - " +
                rs.getString("estado")
            );
        }

    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }
}

public void atualizar(Cliente cliente) {

    String sql = """
        UPDATE clientes
        SET nome = ?, cidade = ?, estado = ?
        WHERE id_cliente = ?
        """;

    try (Connection con = Conexao.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCidade());
        stmt.setString(3, cliente.getEstado());
        stmt.setInt(4, cliente.getIdCliente());

        stmt.executeUpdate();

        System.out.println("Cliente atualizado!");

    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }
}

public void excluir(int id) {

    String sql =
        "DELETE FROM clientes WHERE id_cliente = ?";

    try (Connection con = Conexao.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setInt(1, id);

        stmt.executeUpdate();

        System.out.println("Cliente excluído!");

    } catch (SQLException e) {
        System.out.println("Erro: " + e.getMessage());
    }
}