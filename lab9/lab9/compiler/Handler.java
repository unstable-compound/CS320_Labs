package compiler;

/** Represents a handler for diagnostics.  In particular applications,
 *  we can use subclasses to specify how diagnostics should be handled.
 */
public abstract class Handler {
    /** Count how many diagnostics have been reported.
     */
    private int numDiagnostics = 0;
    public int getNumDiagnostics() {
        return numDiagnostics;
    }

    /** Count how many failures have been reported.
     */
    private int numFailures = 0;
    public int getNumFailures() {
        return numFailures;
    }

    /** Signal whether failures have been detected.
     */
    public boolean hasFailures() {
        return numFailures > 0;
    }

    /** Report a problem to this diagnostic handler.
     */
    public void report(Diagnostic d) {
        numDiagnostics++;
        if (d instanceof Failure) {
            numFailures++;
        }
        respondTo(d);
    }

    /** Respond to a diagnostic report.  Subclasses should
     *  override this method to deal with diagnostic reports in an
     *  appropriate way.  Diagnostics will normally be passed to this
     *  method indirectly via a call to report() in the client code.
     */
    protected abstract void respondTo(Diagnostic d);

    /** Reset the diagnostic handler.  This should set the diagnostic
     *  handler back to the state of a freshly created handler.  As a
     *  default, we just reset the counters.
     */
    public void reset() {
        numDiagnostics = 0;
        numFailures    = 0;
    }
}

