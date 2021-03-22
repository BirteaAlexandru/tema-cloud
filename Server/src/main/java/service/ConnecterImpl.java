package service;

import io.grpc.stub.StreamObserver;
import proto.ConnecterGrpc;
import proto.User;

public class ConnecterImpl extends ConnecterGrpc.ConnecterImplBase {
    /*
    * We observe here that some words have an "@", this are Annotations. Annotations are used to provide supplement
    * information about a program. We can autogenerate this functions, in Intellij we can use the shortcut ctrl + O to
    * do this.
    * */
    @Override
    public void sayNameAndAge(User.UserRequest request, StreamObserver<User.UserReply> responseObserver) {
        int age;


        User.UserReply reply = User.UserReply.newBuilder().setMessage("Hello " + request.getName()+ " you are ").build();
        /* We can call multiple times onNext function if we have multiple replies, ex. in next commits */
        responseObserver.onNext(reply);
        /* We use the response observer's onCompleted method to specify that we've finished dealing with the RPC */
        responseObserver.onCompleted();
    }


}
