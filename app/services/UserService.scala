package services

trait UserService {

  def foo: String

}

class DefaultUserService extends UserService {
  def foo: String = "foo"
}
