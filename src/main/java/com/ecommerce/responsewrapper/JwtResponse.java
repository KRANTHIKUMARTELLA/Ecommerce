package com.ecommerce.responsewrapper;




public class JwtResponse {
	
	private String jwtToken;
    private String username;


    public JwtResponse() {
    }

    // Parameterized constructor
    public JwtResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    // Getter for jwtToken
    public String getJwtToken() {
        return jwtToken;
    }

    // Setter for jwtToken
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // toString method (optional)
    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwtToken='" + jwtToken + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    // Static Builder class
    public static class Builder {
        private String jwtToken;
        private String username;

        // Method to set jwtToken
        public Builder setJwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        // Method to set username
        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        // Build method to create an instance of JwtResponse
        public JwtResponse build() {
            return new JwtResponse(jwtToken, username);
        }
    }

}
