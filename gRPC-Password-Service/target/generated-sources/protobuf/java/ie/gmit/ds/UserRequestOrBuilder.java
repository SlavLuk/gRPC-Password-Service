// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

public interface UserRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ie.gmit.ds.UserRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *userId, password
   * </pre>
   *
   * <code>int32 userId = 1;</code>
   * @return The userId.
   */
  int getUserId();

  /**
   * <code>string password = 2;</code>
   * @return The password.
   */
  java.lang.String getPassword();
  /**
   * <code>string password = 2;</code>
   * @return The bytes for password.
   */
  com.google.protobuf.ByteString
      getPasswordBytes();
}
