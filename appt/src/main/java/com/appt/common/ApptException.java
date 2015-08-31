package com.appt.common;

/**
 * The ApptException class is a generic RuntimeException for non-recoverable
 * errors thrown in the application that do not have a specific exception.
 */
public class ApptException extends RuntimeException {
	private static final long serialVersionUID = 8081482939542086104L;
	private String messageCode;

	/**
	 * Constructs a new exception with the specified detail message. The cause
	 * is not initialized, and may subsequently be initialized by a call to
	 * {@link #initCause}.
	 * 
	 */
	public ApptException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * <p>
	 * Note that the detail message associated with <code>cause</code> is
	 * <i>not</i> automatically incorporated in this runtime exception's detail
	 * message.
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public ApptException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new exception with the specified detail message. The cause
	 * is not initialized, and may subsequently be initialized by a call to
	 * {@link #initCause}.
	 * 
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the {@link #getMessage()} method.
	 */
	public ApptException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message
	 * of <tt>(cause==null ? null : cause.toString())</tt> (which typically
	 * contains the class and detail message of <tt>cause</tt>). This
	 * constructor is useful for runtime exceptions that are little more than
	 * wrappers for other throwables.
	 * 
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public ApptException(Throwable cause) {
		super(cause);
	}

/**
     * Returns {@link RuntimeException#toString() appended with the message code if it
     * exists
     * @return String exception string
     */
	@Override
	public String toString() {
		String retval = null;

		if (this.messageCode == null) {
			retval = super.toString();
		} else {
			retval = super.toString() + " MESSAGE CODE:" + this.messageCode;
		}

		return retval;
	}

	/**
	 * Simple Getter for messageCode property
	 * 
	 * @return The message code
	 */
	public String getMessageCode() {
		return this.messageCode;
	}

	/**
	 * Simple Setter for messageCode property
	 * 
	 * @param messageCode
	 *            The messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
}
