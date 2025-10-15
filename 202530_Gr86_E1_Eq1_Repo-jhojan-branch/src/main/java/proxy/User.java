package proxy;

/**
 * Representa a un usuario con un rol específico.
 */
public class User {
    private final String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
