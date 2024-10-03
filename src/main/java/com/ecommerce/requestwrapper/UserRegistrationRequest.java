package com.ecommerce.requestwrapper;





public class UserRegistrationRequest {

        private String username;
        private String password;
        private String email;
        private String phone;
        private String picture;
        private String address;

        public UserRegistrationRequest(){

        }

        public UserRegistrationRequest(String username, String password, String email, String phone, String picture, String address) {
                this.username = username;
                this.password = password;
                this.email = email;
                this.phone = phone;
                this.picture = picture;
                this.address = address;
        }

        // Getters
        public String getUsername() {
                return username;
        }

        public String getPassword() {
                return password;
        }

        public String getEmail() {
                return email;
        }

        public String getPhone() {
                return phone;
        }

        public String getPicture() {
                return picture;
        }

        public String getAddress() {
                return address;
        }

        // Setters
        public void setUsername(String username) {
                this.username = username;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public void setPicture(String picture) {
                this.picture = picture;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        // toString method
        @Override
        public String toString() {
                return "UserRegistrationRequest{" +
                        "username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", email='" + email + '\'' +
                        ", phone='" + phone + '\'' +
                        ", picture='" + picture + '\'' +
                        ", address='" + address + '\'' +
                        '}';
        }




}
