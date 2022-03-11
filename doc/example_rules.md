

# Create a user with helper functions to debug
rule "Create User"
    when
        CreateUser(name : name, uuid : uuid, groups : groups)
    then
        System.out.println("New user created: " + name + " - " + uuid);
        System.out.println("Groups: " + groups);
//        helper(drools);
//        help(drools, "name " + name);
end



# Execute a system command
rule "Create User with system call"
    when
        CreateUser(name : name, uuid : uuid, groups : groups)
    then
        // String cmd = "google-chrome";
        // String cmd = ""ls -la";

        String cmd = "/home/jerome/ve/radon-lib/bin/radmin moduser " + name + " administrator true";
        System.out.println("(Exec) - New User : " + name);
        System.out.println(cmd);
        SystemCommands.execCommand(cmd);
end

# Add a condition on a user name
rule "Create User with a condition"
    when
        CreateUser(name contains "Patricia", uuid : uuid, groups : groups)
    then
        System.out.println("Patricia created");
end

# Update a user (make it not admin)
rule "Update User"
    when
        UpdateUser(userPre: userPre, userPost : userPost)
    then
        System.out.println("User modified: ");
        System.out.println("Name: " + userPre.getName() + "->" + userPost.getName());
        System.out.println("Email: " + userPre.getEmail() + "->" + userPost.getEmail());
        System.out.println("UUID: " + userPre.getUuid() + "->" + userPost.getUuid());
        System.out.println("Active: " + userPre.getActive() + "->" + userPost.getActive());
        
        String cmd = "/home/jerome/ve/radon-lib/bin/radmin moduser " + userPre.getName() + " administrator false";
        SystemCommands.execCommand(cmd);
end
